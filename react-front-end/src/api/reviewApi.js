// src/api/reviewApi.js
import axios from "axios";

const API_URL = "http://localhost:8080/TutorMe-ADP3-Capstone/spring-boot-application/review";

const api = axios.create({
    baseURL: API_URL,
    headers: { "Content-Type": "application/json" },
});

export const getAllReviews = async () => {
    const response = await api.get("/all");
    return response.data;
};

export const getReviewById = async (id) => {
    const response = await api.get(`/read/${id}`);
    return response.data;
};

export const createReview = async (review) => {
    const response = await api.post("/create", review);
    return response.data;
};

export const updateReview = async (review) => {
    const response = await api.put("/update", review);
    return response.data;
};

export const deleteReview = async (id) => {
    await api.delete(`/delete/${id}`);
};