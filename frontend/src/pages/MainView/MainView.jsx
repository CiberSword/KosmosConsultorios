import { NavBar } from '@/components/NavBar/NavBar.jsx';
import { MedicalAppointmentCreation } from '@/views/MedicalAppointmentCreation/MedicalAppointmentCreation .jsx';
import { Box } from '@mui/material';
import { StartPage } from '@/views/StartPage/StartPage.jsx';

export const MainView = () => {
  return (
    <Box
      sx={{
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        width: '100vw',
        height: '100vh',
        gap: '2rem'
      }}
    >
      <NavBar />
      <StartPage />
    </Box>
  );
};
