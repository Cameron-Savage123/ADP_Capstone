// src/pages/CrudDisplayTest.jsx
import React, { useState, useEffect } from "react";
import { getAllPayments } from "../api/paymentApi";
import PaymentTable from "../components/PaymentTable";
import { getAllReviews } from "../api/reviewApi";
import ReviewTable from "../components/ReviewTable";

export default function CrudDisplay() {
    const [activeTab, setActiveTab] = useState("User");
    const [data, setData] = useState({
        User: [
            { userId: 1, firstName: "John", lastName: "Doe", phoneNumber: "1234567890", email: "john@example.com", password: "hashed_pw" },
            { userId: 2, firstName: "Jane", lastName: "Smith", phoneNumber: "0987654321", email: "jane@example.com", password: "hashed_pw" },
        ],
        University: [
            { universityId: 1, universityName: "CPUT", location: "Cape Town", domain: "cput.ac.za" },
            { universityId: 2, universityName: "UCT", location: "Cape Town", domain: "uct.ac.za" },
        ],
        Tutor: [
            { tutorID: 1, hourlyRate: 200, bio: "Math wizard", averageRating: 4.8, verificationStatus: "Verified" },
            { tutorID: 2, hourlyRate: 150, bio: "Physics expert", averageRating: 4.5, verificationStatus: "Pending" },
        ],
        Subject: [
            { subjectCode: "MATH101", subjectName: "Calculus", subjectDescription: "Intro to calculus", department: "Mathematics", difficultyLevel: "Hard" },
            { subjectCode: "CS201", subjectName: "Data Structures", subjectDescription: "Study of data structures", department: "Computer Science", difficultyLevel: "Medium" },
        ],
        Student: [
            { studentID: 1, studentNumber: "S12345", studentCourse: "Computer Science", yearOfStudy: 2 },
            { studentID: 2, studentNumber: "S67890", studentCourse: "Engineering", yearOfStudy: 3 },
        ],
        Session: [
            { sessionId: 1, startTime: "2025-08-24T10:00", endTime: "2025-08-24T12:00", location: "Online", mode: "Virtual", cost: 400, status: "Completed", notes: "Great session" },
            { sessionId: 2, startTime: "2025-08-25T14:00", endTime: "2025-08-25T16:00", location: "Campus A", mode: "In-person", cost: 350, status: "Booked", notes: "" },
        ],
        Review: [],
        //   { reviewID: 1, rating: 5, comment: "Excellent tutor!", dateSubmitted: "2025-08-20" },
        //    { reviewID: 2, rating: 4, comment: "Very helpful", dateSubmitted: "2025-08-21" },
        //  ],
        Payment: [], // live data
        Availability: [
            { availabilityID: 1, dayOfWeek: "Monday", startTime: "09:00", endTime: "12:00" },
            { availabilityID: 2, dayOfWeek: "Wednesday", startTime: "14:00", endTime: "17:00" },
        ],
    });

    const [loading, setLoading] = useState(false);

    const fetchPaymentData = async () => {
        setLoading(true);
        try {
            const payments = await getAllPayments();
            setData(prev => ({ ...prev, Payment: payments }));
        } catch (error) {
            console.error("Error fetching Payment data:", error);
        } finally {
            setLoading(false);
        }
    };

    // Fetch Review data
    const fetchReviewData = async () => {
        setLoading(true);
        try {
            const reviews = await getAllReviews();
            setData(prev => ({ ...prev, Review: reviews }));
        } catch (error) {
            console.error("Error fetching Review data:", error);
        } finally {
            setLoading(false);
        }
    };

    // Handle View button
    const handleView = () => {
        if (activeTab === "Payment") {
            fetchPaymentData();
        } else if (activeTab === "Review") {
            fetchReviewData();
        } else {
            alert(`Viewing ${activeTab} tab data (mock data)`);
        }
    };

    const renderTable = (rows) => {
        if (!rows || rows.length === 0) return <p>No data available</p>;
        const headers = Object.keys(rows[0]);
        return (
            <table className="w-full border border-gray-300 rounded-lg overflow-hidden shadow">
                <thead className="bg-blue-600 text-white">
                <tr>
                    {headers.map((header) => (
                        <th key={header} className="px-4 py-2 text-left">{header}</th>
                    ))}
                </tr>
                </thead>
                <tbody>
                {rows.map((row, idx) => (
                    <tr key={idx} className="odd:bg-gray-100 even:bg-white hover:bg-gray-200">
                        {headers.map((header) => (
                            <td key={header} className="px-4 py-2 border-t">{row[header]}</td>
                        ))}
                    </tr>
                ))}
                </tbody>
            </table>
        );
    };

    return (
        <div className="p-6">
            <h1 className="text-3xl font-bold mb-6">CRUD Display</h1>

            {/* Tabs */}
            <div className="flex flex-wrap gap-3 mb-6">
                {Object.keys(data).map((table) => (
                    <button
                        key={table}
                        onClick={() => setActiveTab(table)}
                        className={`px-4 py-2 rounded-lg shadow ${activeTab === table ? "bg-blue-600 text-white" : "bg-gray-200 hover:bg-gray-300"}`}
                    >
                        {table}
                    </button>
                ))}
            </div>

            {/* Active Tab Content */}
            <div className="bg-white shadow-lg rounded-xl p-6">
                <div className="flex justify-between items-center mb-4">
                    <h2 className="text-xl font-semibold">{activeTab} Data</h2>
                    <button
                        onClick={handleView}
                        className="px-4 py-2 bg-green-600 text-white rounded-lg shadow hover:bg-green-700"
                    >
                        {loading ? "Loading..." : "View"}
                    </button>
                </div>

                {activeTab === "Payment" ? (
                    <PaymentTable payments={data.Payment} />
                ) : activeTab === "Review" ? (
                    <ReviewTable reviews={data.Review} />
                ) : (
                    renderTable(data[activeTab])
                )}
            </div>
        </div>
    );
}