// src/api/sessionApi.js
import axios from "axios";

const BASE_URL = "http://localhost:8080/ADP_Capstone/spring-boot-application/session";

export const getAllSessions = async () => {
    const response = await axios.get(BASE_URL);
    return response.data;
};

export const createSession = async (session) => {
    const response = await axios.post(BASE_URL, session);
    return response.data;
};

export const updateSession = async (sessionId, session) => {
    const response = await axios.put(`${BASE_URL}/${sessionId}`, session);
    return response.data;
};

export const deleteSession = async (sessionId) => {
    const response = await axios.delete(`${BASE_URL}/${sessionId}`);
    return response.data;
};
