import React, { useState } from "react";

export default function Bookings() {
    // Example tutors (later this would come from backend or context)
    const tutors = ["Sarah Johnson", "Michael Smith", "Aisha Patel"];

    const [formData, setFormData] = useState({
        tutor: "",
        startTime: "",
        endTime: "",
        location: "",
        mode: "",
    });

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("Booking submitted:", formData);
        alert("Booking submitted! 🎉");
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

                {/* Start time */}
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

                {/* End time */}
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

                {/* Submit */}
                <button
                    type="submit"
                    className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700"
                >
                    Confirm Booking
                </button>
            </form>
        </div>
    );
}