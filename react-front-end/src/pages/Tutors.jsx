import React from "react";
import { Link } from "react-router-dom";

export default function Tutors() {
    // Example tutor data (replace with API call later)
    const tutors = [
        {
            name: "Sarah Johnson",
            hourlyRate: "R200/hr",
            bio: "Math and Physics tutor with 5 years of experience helping high school and first-year university students.",
            averageRating: 4.8,
            verificationStatus: "Verified ✅",
        },
        {
            name: "Michael Smith",
            hourlyRate: "R150/hr",
            bio: "Passionate Computer Science tutor specializing in Java, Python, and web development.",
            averageRating: 4.6,
            verificationStatus: "Verified ✅",
        },
        {
            name: "Aisha Patel",
            hourlyRate: "R180/hr",
            bio: "English and Creative Writing tutor. Focus on improving academic writing and communication skills.",
            averageRating: 4.9,
            verificationStatus: "Pending ⏳",
        },
    ];

    return (
        <div className="max-w-4xl mx-auto py-12 px-4">
            <h2 className="text-3xl font-bold mb-8 text-center">Tutors</h2>
            <p className="text-gray-600 text-center mb-10">
                Here you will see a list of all available tutors.
            </p>

            <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
                {tutors.map((tutor, index) => (
                    <div
                        key={index}
                        className="p-6 bg-white rounded-xl shadow hover:shadow-lg transition"
                    >
                        <h3 className="text-xl font-semibold mb-2">{tutor.name}</h3>
                        <p className="text-blue-600 font-medium">{tutor.hourlyRate}</p>
                        <p className="mt-2 text-gray-700">{tutor.bio}</p>
                        <p className="mt-3 text-sm text-gray-600">
                            ⭐ {tutor.averageRating} / 5
                        </p>
                        <p className="text-sm text-gray-500">{tutor.verificationStatus}</p>

                        {/* Book Now button */}
                        <div className="mt-4">
                            <Link
                                to="/bookings"
                                className="inline-block w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700 text-center"
                            >
                                Book Now
                            </Link>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}