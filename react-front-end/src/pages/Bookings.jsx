// src/pages/Bookings.jsx
import React, { useState, useEffect } from "react";
import { createPayment } from "../api/paymentApi";
import { getAllSubjects } from "../api/subjectApi";

export default function Bookings() {
    const tutors = ["Sarah Johnson", "Michael Smith", "Aisha Patel"];

    const [subjectsList, setSubjectsList] = useState([]);

    const [formData, setFormData] = useState({
        tutor: "",
        startTime: "",
        endTime: "",
        location: "",
        mode: "",
        amount: "",
        paymentMethod: "",
        subjectCode: "",
    });

    // Load subjects from database
    useEffect(() => {
        const fetchSubjects = async () => {
            try {
                const data = await getAllSubjects();
                setSubjectsList(data);
            } catch (error) {
                console.error("Error fetching subjects:", error);
            }
        };
        fetchSubjects();
    }, []);

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    // Helper to generate IDs
    const generateID = (prefix) =>
        `${prefix}-${Math.random().toString(36).substring(2, 10).toUpperCase()}`;

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!formData.amount || !formData.paymentMethod || !formData.subjectCode) {
            alert("Please select a subject and provide payment details before confirming.");
            return;
        }

        const newPayment = {
            paymentID: generateID("PAY"),
            amount: parseFloat(formData.amount),
            paymentDate: new Date().toISOString(),
            paymentMethod: formData.paymentMethod,
            status: "Pending",
            transactionID: generateID("TXN"),
        };

        try {
            await createPayment(newPayment);
            console.log("Payment recorded:", newPayment);
            alert("Booking confirmed and payment recorded successfully! 💸");

            // Reset form
            setFormData({
                tutor: "",
                startTime: "",
                endTime: "",
                location: "",
                mode: "",
                amount: "",
                paymentMethod: "",
                subjectCode: "",
            });
        } catch (error) {
            console.error("Error creating payment:", error);
            alert("Failed to record payment. Please try again.");
        }
    };

    return (
        <div className="max-w-2xl mx-auto py-12 px-4">
            <h2 className="text-3xl font-bold mb-6 text-center">Book a Tutor</h2>

            <form
                onSubmit={handleSubmit}
                className="space-y-6 bg-white p-6 rounded-xl shadow"
            >
                {/* Tutor dropdown */}
                <div>
                    <label className="block font-medium mb-2">Select Tutor</label>
                    <select
                        name="tutor"
                        value={formData.tutor}
                        onChange={handleChange}
                        className="w-full border rounded px-3 py-2"
                        required
                    >
                        <option value="">-- Choose a tutor --</option>
                        {tutors.map((tutor, index) => (
                            <option key={index} value={tutor}>
                                {tutor}
                            </option>
                        ))}
                    </select>
                </div>

                {/* Subject dropdown */}
                <div>
                    <label className="block font-medium mb-2">Select Subject</label>
                    <select
                        name="subjectCode"
                        value={formData.subjectCode}
                        onChange={handleChange}
                        className="w-full border rounded px-3 py-2"
                        required
                    >
                        <option value="">-- Choose a subject --</option>
                        {subjectsList.map((subject) => (
                            <option key={subject.subjectCode} value={subject.subjectCode}>
                                {subject.subjectCode} - {subject.subjectName}
                            </option>
                        ))}
                    </select>
                </div>

                {/* Start Time */}
                <div>
                    <label className="block font-medium mb-2">Start Time</label>
                    <input
                        type="datetime-local"
                        name="startTime"
                        value={formData.startTime}
                        onChange={handleChange}
                        className="w-full border rounded px-3 py-2"
                        required
                    />
                </div>

                {/* End Time */}
                <div>
                    <label className="block font-medium mb-2">End Time</label>
                    <input
                        type="datetime-local"
                        name="endTime"
                        value={formData.endTime}
                        onChange={handleChange}
                        className="w-full border rounded px-3 py-2"
                        required
                    />
                </div>

                {/* Location */}
                <div>
                    <label className="block font-medium mb-2">Location (Campus)</label>
                    <input
                        type="text"
                        name="location"
                        value={formData.location}
                        onChange={handleChange}
                        className="w-full border rounded px-3 py-2"
                        placeholder="e.g., Bellville Campus"
                        required
                    />
                </div>

                {/* Mode */}
                <div>
                    <label className="block font-medium mb-2">Mode</label>
                    <select
                        name="mode"
                        value={formData.mode}
                        onChange={handleChange}
                        className="w-full border rounded px-3 py-2"
                        required
                    >
                        <option value="">-- Select mode --</option>
                        <option value="Online">Online</option>
                        <option value="In Person">In Person</option>
                    </select>
                </div>

                {/* Payment Section */}
                <div className="border-t pt-6 mt-6">
                    <h3 className="text-xl font-semibold mb-4 text-center">
                        Payment Details
                    </h3>

                    {/* Amount */}
                    <div className="mb-4">
                        <label className="block font-medium mb-2">Amount (ZAR)</label>
                        <input
                            type="number"
                            name="amount"
                            min="0"
                            step="0.01"
                            value={formData.amount}
                            onChange={handleChange}
                            className="w-full border rounded px-3 py-2"
                            placeholder="Enter amount e.g. 250"
                            required
                        />
                    </div>

                    {/* Payment Method */}
                    <div>
                        <label className="block font-medium mb-2">Payment Method</label>
                        <select
                            name="paymentMethod"
                            value={formData.paymentMethod}
                            onChange={handleChange}
                            className="w-full border rounded px-3 py-2"
                            required
                        >
                            <option value="">-- Choose payment method --</option>
                            <option value="Credit Card">Credit Card</option>
                            <option value="Debit Card">Debit Card</option>
                            <option value="EFT">EFT</option>
                            <option value="PayPal">PayPal</option>
                            <option value="Cash">Cash</option>
                        </select>
                    </div>
                </div>

                {/* Submit */}
                <button
                    type="submit"
                    className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700 transition"
                >
                    Confirm Booking
                </button>
            </form>
        </div>
    );
}
