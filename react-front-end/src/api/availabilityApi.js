// src/api/availabilityApi.js
import axios from "axios";

const BASE_URL = "http://localhost:8080/TutorMe-ADP3-Capstone/spring-boot-application/availability";

export const getAllAvailabilities = async () => {
    const response = await axios.get(BASE_URL);
    return response.data;
};

export const createAvailability = async (availability) => {
    const response = await axios.post(BASE_URL, availability);
    return response.data;
};

export const updateAvailability = async (id, availability) => {
    const response = await axios.put(`${BASE_URL}/${id}`, availability);
    return response.data;
};

export const deleteAvailability = async (id) => {
    const response = await axios.delete(`${BASE_URL}/${id}`);
    return response.data;
};
