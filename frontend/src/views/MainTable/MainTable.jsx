import { useEffect, useState } from 'react';

import {
  Box,
  Button,
  IconButton,
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
} from '@mui/material';
import { Icon } from '@iconify/react';
import axios from 'axios';
import Swal from 'sweetalert2';
import dayjs from 'dayjs';
import 'dayjs/locale/es';
import { deleteCita, fetchCitas } from '@/services/apiServices.js';
dayjs.locale('es');

export const MainTable = ({ handleMode, handleInitialData }) => {
  const apiUrl = import.meta.env.VITE_API_BASE_URL;
  const [citasData, setCitasData] = useState([]);
  const dateFormat = 'YYYY-MM-DDTHH:mm:ss';

  useEffect(() => {
    getCitasData();
  }, []);

  const getCitasData = async () => {
    const citasResponse = await fetchCitas()
    setCitasData(citasResponse?.data);
  };

  const removeCita = async (id) => {
    await deleteCita(id)
    return getCitasData();
  };

  const createCita = () => {
    handleInitialData(null);
    handleMode('FORM_VIEW');
  };

  const editCita = (row) => {
    handleInitialData(row);
    handleMode('FORM_VIEW');
  };

  const openDeleteConfirmModal = (row) => {
    Swal.fire({
      text: '¿Estás seguro de eliminar esta fila?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Confirmar',
      cancelButtonText: 'Cancelar',
      confirmButtonColor: '#ff0000',
    }).then((result) => {
      result.isConfirmed && removeCita(row.id);
    });
  };

  return (
    <Box>
      <TableContainer
        component={Paper}
        sx={{ padding: '2rem', display: 'flex', flexDirection: 'column' }}
      >
        <Button variant={'contained'} sx={{ maxWidth: '12rem' }} onClick={createCita}>
          Insertar registro
        </Button>

        <Table sx={{ minWidth: 850 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell>Id</TableCell>
              <TableCell>Consultorio</TableCell>
              <TableCell>Doctor</TableCell>
              <TableCell>Horario Consulta</TableCell>
              <TableCell>Nombre Paciente</TableCell>
              <TableCell>Acciones</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {citasData?.map((row) => (
              <TableRow key={row.id}>
                <TableCell>{row.id}</TableCell>
                <TableCell>{row?.consultorio?.numeroConsultorio} - {row?.consultorio?.piso}</TableCell>
                <TableCell>{row.doctor?.nombre} {row.doctor?.apellidoPaterno}</TableCell>
                <TableCell>{row.horarioConsulta}</TableCell>
                <TableCell>{row.nombrePaciente}</TableCell>
                <TableCell>
                  {
                    <div>
                      <IconButton sx={{ color: '#0c2d73' }} onClick={() => editCita(row)}>
                        <Icon icon="mdi:pencil" />
                      </IconButton>
                      <IconButton sx={{ color: 'red' }} onClick={() => openDeleteConfirmModal(row)}>
                        <Icon icon="mdi:trash-can" />
                      </IconButton>
                    </div>
                  }
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </Box>
  );
};
