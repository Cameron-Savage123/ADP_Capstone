// src/api/universityApi.js
import axios from "axios";

const BASE_URL = "http://localhost:8080/ADP_Capstone/spring-boot-application/university";

export const getAllUniversities = async () => {
    const response = await axios.get(BASE_URL);
    return response.data;
};

export const createUniversity = async (university) => {
    const response = await axios.post(BASE_URL, university);
    return response.data;
};

export const updateUniversity = async (universityId, university) => {
    const response = await axios.put(`${BASE_URL}/${universityId}`, university);
    return response.data;
};

export const deleteUniversity = async (universityId) => {
    const response = await axios.delete(`${BASE_URL}/${universityId}`);
    return response.data;
};
