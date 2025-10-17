import React from "react";
import { Link } from "react-router-dom";
import banner from "../assets/Home_Page_Students.jpg";

export default function Home() {
    return (
        <div className="text-center py-12">
            <h2 className="text-4xl font-bold mb-4">Welcome to TutorConnect</h2>

            <div className="w-full max-w-2xl">
                <img
                    src={banner}
                    alt="TutorConnect Banner"
                    className="w-full h-auto object-cover rounded-2xl shadow-lg"
                    style={{ maxHeight: "60vh" }}
                />
            </div>

            <p className="text-lg">Book and pay for tutors easily with our platform.</p>

            <p className="text-xl text-white font-medium mb-6">
                Ready to get started? Try booking one of our many tutors!
            </p>

            <Link
                to="/tutors"
                className="bg-gradient-to-r from-blue-500 to-blue-700 hover:from-blue-600 hover:to-blue-800 text-white font-semibold py-3 px-8 rounded-full shadow-lg transition-transform duration-300 hover:scale-105"
            >
                Explore Tutors
            </Link>
        </div>
    );
}