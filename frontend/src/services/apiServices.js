import { axiosClient } from '@/services/axiosClient.js';

export const fetchConsultorios = async () => {
  const response = await axiosClient.get(`consultorio`);
  return response.data;
};

export const fetchDoctores = async () => {
  const response = await axiosClient.get(`doctor`);
  return response.data;
};

export const fetchCitas = async () => {
  const response = await axiosClient.get(`cita`);
  return response.data;
};

export const postCita = async (body) => {
  const response = await axiosClient.post(`cita`, body);
  return response.data;
};

export const putCita = async (body) => {
  const response = await axiosClient.put(`cita`, body);
  return response.data;
};

export const deleteCita = async (id) => {
  const response = await axiosClient.delete(`cita/${id}`);
  return response.data;
};