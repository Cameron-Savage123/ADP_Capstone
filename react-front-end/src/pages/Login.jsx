import React, { useState } from "react";
import { Link } from "react-router-dom";

export default function Login() {
    const [formData, setFormData] = useState({
        email: "",
        password: "",
    });

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Placeholder: later connect to Spring Boot login API
        console.log("Login data:", formData);
        alert("Login submitted!");
    };

    return (
        <div className="max-w-md mx-auto mt-12 p-6 bg-white rounded-xl shadow text-center">
            <h2 className="text-3xl font-bold mb-4">Login</h2>
            <p className="mb-6 text-gray-600">Login page for tutors and students.</p>

            <form onSubmit={handleSubmit} className="space-y-4 text-left">
                <div>
                    <label className="block mb-1 font-medium">Email</label>
                    <input
                        type="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        className="w-full border rounded px-3 py-2"
                        required
                    />
                </div>

                <div>
                    <label className="block mb-1 font-medium">Password</label>
                    <input
                        type="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        className="w-full border rounded px-3 py-2"
                        required
                    />
                </div>

                <button
                    type="submit"
                    className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700"
                >
                    Login
                </button>
            </form>

            <p className="mt-4 text-gray-600">
                Don’t have an account?{" "}
                <Link to="/register" className="text-blue-600 hover:underline">
                    Register here
                </Link>
            </p>
        </div>
    );
}