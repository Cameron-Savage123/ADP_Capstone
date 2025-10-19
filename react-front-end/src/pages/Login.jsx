// src/pages/Login.jsx
import React, { useState, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function Login() {
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        email: "",
        password: "",
    });

    const [users, setUsers] = useState([]);

    // Load users from localStorage or fallback to defaults
    useEffect(() => {
        const storedUsers = JSON.parse(localStorage.getItem("users"));
        if (storedUsers && storedUsers.length > 0) {
            setUsers(storedUsers);
        } else {
            const defaultUsers = [
                { name: "Student One", email: "student1@gmail.com", password: "pass123" },
                { name: "Student Two", email: "student2@gmail.com", password: "mypassword" },
                { name: "Tutor One", email: "tutor1@gmail.com", password: "tutorpass" },
            ];
            localStorage.setItem("users", JSON.stringify(defaultUsers));
            setUsers(defaultUsers);
        }
    }, []);

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        const { email, password } = formData;

        // Admin login
        if (email === "admin@gmail.com" && password === "password") {
            const admin = { name: "Admin", email: "admin@gmail.com", role: "admin" };
            localStorage.setItem("loggedInUser", JSON.stringify(admin));
            window.dispatchEvent(new Event("authChange"));
            alert("Welcome, Admin. Redirecting to Admin Dashboard...");
            navigate("/admin");
            return;
        }

        // Check users
        const matchedUser = users.find(
            (user) => user.email === email && user.password === password
        );

        if (matchedUser) {
            const userObj = { name: matchedUser.name, email: matchedUser.email, role: "user" };
            localStorage.setItem("loggedInUser", JSON.stringify(userObj));
            window.dispatchEvent(new Event("authChange"));
            alert(`Welcome back, ${matchedUser.name}! Redirecting...`);
            navigate("/user");
        } else {
            alert("Invalid credentials. Please try again!");
        }
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
                    className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700 transition"
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
