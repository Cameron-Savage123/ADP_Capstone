// src/api/paymentApi.js
import axios from "axios";

const API_URL = "http://localhost:8080/TutorMe-ADP3-Capstone/spring-boot-application/payment";

const api = axios.create({
    baseURL: API_URL,
    headers: { "Content-Type": "application/json" },
});

export const getAllPayments = async () => {
    const response = await api.get("/all");
    return response.data;
};

export const getPaymentById = async (id) => {
    const response = await api.get(`/read/${id}`);
    return response.data;
};

export const createPayment = async (payment) => {
    const response = await api.post("/create", payment);
    return response.data;
};

export const updatePayment = async (payment) => {
    const response = await api.put("/update", payment);
    return response.data;
};

export const deletePayment = async (id) => {
    await api.delete(`/delete/${id}`);
};