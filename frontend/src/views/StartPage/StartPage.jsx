import { Box, Typography } from '@mui/material';
import { useState } from 'react';
import { MedicalAppointmentCreation } from '@/views/MedicalAppointmentCreation/MedicalAppointmentCreation .jsx';
import { MainTable } from '@/views/MainTable/MainTable.jsx';

export const StartPage = () => {
  const [mode, setMode] = useState('TABLE_VIEW');
  const [initialFormData, setInitialFormData] = useState();

  const handleMode = (mode) => setMode(mode);
  const handleInitialData = (data) => {
   if (data) {
     setInitialFormData( {
       id: data.id,
       consultorioId: data?.consultorio?.id,
       doctorId: data?.doctor?.id,
       horarioConsulta: data?.horarioConsulta,
       nombrePaciente: data?.nombrePaciente,
     })
   }
   else setInitialFormData(null)
  }

  const RENDER_COMPONENT = {
    TABLE_VIEW: <MainTable handleMode={handleMode} handleInitialData={handleInitialData} />,
    FORM_VIEW: <MedicalAppointmentCreation handleMode={handleMode} initialFormData={initialFormData} />,
  };

  return (
    <Box sx={{ display: 'flex', flexDirection: 'column', gap: '2rem' }}>
      <Typography variant="h4">Administración de Personal</Typography>
      {RENDER_COMPONENT[mode]}
    </Box>
  );
};
