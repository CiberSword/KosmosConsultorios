import { useEffect, useState } from 'react';
import {
  TextField,
  Button,
  Box,
  IconButton,
  Typography,
  Stack,
  Select,
  MenuItem,
} from '@mui/material';
import { DateTimePicker } from '@mui/x-date-pickers/DateTimePicker';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import Swal from 'sweetalert2';
import dayjs from 'dayjs';
import 'dayjs/locale/es';
import { fetchConsultorios, fetchDoctores, postCita, putCita } from '@/services/apiServices.js';
import { Icon } from '@iconify/react';
dayjs.locale('es');

export const MedicalAppointmentCreation = ({ handleMode, initialFormData }) => {
  const dateFormat = 'YYYY-MM-DDTHH:mm:ss';
  const currentDate = dayjs(new Date()).format(dateFormat);
  const emptyForm = {
    consultorioId: ' ',
    doctorId: ' ',
    horarioConsulta: currentDate,
    nombrePaciente: '',
  };
  const [formData, setFormData] = useState(initialFormData || emptyForm);
  const isFormEmpty = Object.values(formData).some((value) => value === '');
  const [doctorOptions, setDoctorOptions] = useState([]);
  const [consultoriosOptions, setConsultoriosOptions] = useState([]);

  console.log("CS_formData", formData);
  useEffect(() => {
    getDoctores();
    getConsultorios();
  }, []);

  const getDoctores = async () => {
    const doctoresResponse = await fetchDoctores();
    setDoctorOptions(doctoresResponse?.data);
  };
  const getConsultorios = async () => {
    const consultoriosResponse = await fetchConsultorios();
    setConsultoriosOptions(consultoriosResponse?.data);
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleDateChange = (date) => {
    setFormData({
      ...formData,
      horarioConsulta: dayjs(date).isValid() ? dayjs(date).format(dateFormat) : '',
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    initialFormData
      ? await putCita(formData)
      : await postCita(formData)
    Swal.fire({
      text: 'Datos envíados correctamente.',
      icon: 'success',
      confirmButtonColor: '#a5dc86',
    }).then(() => {
      handleMode('TABLE_VIEW');
    });
  };


  return (
    <Stack
      sx={{
        backgroundColor: 'white',
        padding: '2rem',
        borderRadius: '5px',
      }}
      spacing={2}
    >
      <Box
        sx={{
          display: 'flex',
          alignItems: 'center',
        }}
      >
        <IconButton sx={{ color: '#0c2d73' }} onClick={() => handleMode('TABLE_VIEW')}>
          <Icon icon="mdi:arrow-left" />
        </IconButton>
        <Typography sx={{ color: 'black' }}>Completa los datos del formulario</Typography>
      </Box>
      <Box
        component="form"
        onSubmit={handleSubmit}
        sx={{
          display: 'flex',
          flexDirection: 'column',
          gap: 2,
          width: '30rem',
        }}
      >
        <Select value={formData.consultorioId} name="consultorioId" onChange={handleChange}>
          <MenuItem disabled value={' '}>
            Selecciona un consultorio
          </MenuItem>
          {consultoriosOptions.map((consultorio) => (
            <MenuItem
              value={consultorio?.id}
            >{`Consultorio No. ${consultorio?.numeroConsultorio}`}</MenuItem>
          ))}
        </Select>
        <Select value={formData.doctorId} name="doctorId" onChange={handleChange}>
          <MenuItem disabled value={' '}>
            Selecciona un médico
          </MenuItem>
          {doctorOptions.map((doctor) => (
            <MenuItem
              value={doctor?.id}
            >{`Dr ${doctor?.nombre} ${doctor?.apellidoPaterno} ${doctor?.apellidoMaterno} - ${doctor?.especialidad?.nombre}`}</MenuItem>
          ))}
        </Select>
        <LocalizationProvider dateAdapter={AdapterDayjs}>
          <DateTimePicker
            label="Horario Consulta"
            value={dayjs(formData?.horarioConsulta, 'YYYY-MM-DDTHH:mm:ss')}
            format={dateFormat}
            onChange={handleDateChange}
          />
        </LocalizationProvider>
        <TextField
          label="Nombre del paciente"
          name="nombrePaciente"
          value={formData.nombrePaciente}
          onChange={handleChange}
        />
        <Button type="submit" variant="contained" color="primary" disabled={isFormEmpty}>
          Enviar
        </Button>
      </Box>
    </Stack>
  );
};
