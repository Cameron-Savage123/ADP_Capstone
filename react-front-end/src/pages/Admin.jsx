import React from "react";
import { useNavigate } from "react-router-dom";

export default function Admin() {
    const navigate = useNavigate();

    return (
        <div className="min-h-screen flex flex-col items-center justify-center bg-gray-100 p-6">
            <div className="max-w-md w-full bg-white rounded-xl shadow p-8 text-center">
                <h2 className="text-3xl font-bold mb-6">Admin Dashboard</h2>
                <p className="text-gray-700 mb-6">
                    Welcome, Admin! Use the buttons below to manage records.
                </p>

                <div className="flex flex-col gap-4">
                    <button
                        onClick={() => navigate("/crud-display")}
                        className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700"
                    >
                        Go to CRUD Display
                    </button>

                    <button
                        onClick={() => navigate("/crud-modify")}
                        className="w-full bg-green-600 text-white py-2 rounded hover:bg-green-700"
                    >
                        Go to CRUD Modify
                    </button>
                </div>

                <p className="text-gray-500 mt-6 text-sm">
                    Click a button to manage your data.
                </p>
            </div>
        </div>
    );
}