/*
Keewan Titus
230778577
 */

// src/api/SubjectApi.js


import axios from "axios";


const BASE_URL = "http://localhost:8080/TutorMe-ADP3-Capstone/spring-boot-application/subject";



export const getAllSubjects = async () => {
    const response = await axios.get(`${BASE_URL}/all`);
    return response.data;
};

export const createSubject = async (subject) => {
    const response = await axios.post(`${BASE_URL}/create`, subject);
    return response.data;
};

export const updateSubject = async (id, subject) => {
    const response = await axios.put(`${BASE_URL}/${id}`, subject);

    return response.data;
};

export const deleteSubject = async (id) => {
    const response = await axios.delete(`${BASE_URL}/${id}`);
    return response.data;
};
