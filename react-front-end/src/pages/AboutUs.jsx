import React from "react";
import bgImage from "../assets/About_Us_Background.jpg";

export default function AboutUs() {
    return (
        <div
            className="min-h-screen flex items-center justify-center"
            style={{
                backgroundImage: `url(${bgImage})`,
                backgroundSize: "cover",
                backgroundPosition: "center",
                //filter: "blur(1px)", // blur effect
                position: "relative",
            }}
        >
            {/* Overlay to hold content on top of blurred background */}
            <div className="absolute inset-0 bg-black bg-opacity-50"></div>

            {/* Content */}
            <div className="relative max-w-4xl mx-auto p-6 bg-white bg-opacity-90 rounded-xl shadow text-center">
                <h2 className="text-3xl font-bold mb-6">About TutorConnect</h2>

                <section className="mb-8 text-left">
                    <h3 className="text-2xl font-semibold mb-2">Our Vision</h3>
                    <p className="text-gray-700">
                        At TutorConnect, our vision is to make quality education accessible to everyone, bridging the gap between students and expert tutors globally.
                    </p>
                </section>

                <section className="text-left">
                    <h3 className="text-2xl font-semibold mb-2">Our Mission</h3>
                    <p className="text-gray-700">
                        Our mission is to create a seamless, user-friendly platform where learners can easily find, book, and connect with tutors. We aim to empower students to achieve their academic goals while supporting tutors to grow their teaching opportunities.
                    </p>
                </section>
            </div>
        </div>
    );
}