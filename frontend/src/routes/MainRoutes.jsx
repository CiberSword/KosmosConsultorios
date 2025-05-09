import { Route, Routes } from 'react-router-dom';
import { MainView } from '@/pages/MainView/MainView.jsx';

export const MainRoutes = () => {
    return (
        <Routes>
            <Route path='/' element={<MainView />} />
        </Routes>
    )
}