import React, { useState } from "react";

export default function User() {
    // Example user details
    const user = {
        name: "Cameron Saurez",
        email: "saurez@example.com",
        role: "Student",
        joined: "March 2024",
    };

    // Example booking history
    const [bookings] = useState([
        {
            tutor: "Sarah Johnson",
            startTime: "2025-08-25T10:00",
            endTime: "2025-08-25T11:00",
            location: "Bellville Campus",
            mode: "In Person",
            status: "Upcoming",
        },
        {
            tutor: "Michael Smith",
            startTime: "2025-08-20T14:00",
            endTime: "2025-08-20T15:30",
            location: "Online",
            mode: "Online",
            status: "Completed",
        },
        {
            tutor: "Aisha Patel",
            startTime: "2025-08-18T09:00",
            endTime: "2025-08-18T10:00",
            location: "Cape Town Campus",
            mode: "In Person",
            status: "Completed",
        },
    ]);

    // State for reviews
    const [reviews, setReviews] = useState([]);

    // Modal state
    const [showReviewModal, setShowReviewModal] = useState(false);
    const [reviewForm, setReviewForm] = useState({
        tutor: "",
        rating: 5,
        comment: "",
    });

    // Handle form change
    const handleChange = (e) => {
        const { name, value } = e.target;
        setReviewForm({ ...reviewForm, [name]: value });
    };

    // Handle review submission
    const submitReview = () => {
        if (!reviewForm.tutor || !reviewForm.comment) {
            alert("Please select a tutor and leave a comment.");
            return;
        }

        const newReview = {
            tutor: reviewForm.tutor,
            rating: reviewForm.rating,
            comment: reviewForm.comment,
            date: new Date().toLocaleString(),
        };

        setReviews([...reviews, newReview]);
        setShowReviewModal(false);
        setReviewForm({ tutor: "", rating: 5, comment: "" });
    };

    return (
        <div className="max-w-4xl mx-auto py-12 px-4">
            {/* User Details */}
            <div className="bg-white p-6 rounded-xl shadow mb-10">
                <h2 className="text-3xl font-bold mb-4">User Profile</h2>
                <p><span className="font-semibold">Name:</span> {user.name}</p>
                <p><span className="font-semibold">Email:</span> {user.email}</p>
                <p><span className="font-semibold">Role:</span> {user.role}</p>
                <p><span className="font-semibold">Joined:</span> {user.joined}</p>
            </div>

            {/* Booking History */}
            <div className="mb-10">
                <h3 className="text-2xl font-bold mb-6">My Bookings</h3>
                <div className="space-y-4">
                    {bookings.map((booking, index) => (
                        <div
                            key={index}
                            className="p-6 bg-white rounded-xl shadow hover:shadow-lg transition"
                        >
                            <h4 className="text-xl font-semibold mb-2">
                                Tutor: {booking.tutor}
                            </h4>
                            <p>
                                <span className="font-semibold">Start:</span>{" "}
                                {new Date(booking.startTime).toLocaleString()}
                            </p>
                            <p>
                                <span className="font-semibold">End:</span>{" "}
                                {new Date(booking.endTime).toLocaleString()}
                            </p>
                            <p>
                                <span className="font-semibold">Location:</span>{" "}
                                {booking.location}
                            </p>
                            <p>
                                <span className="font-semibold">Mode:</span> {booking.mode}
                            </p>
                            <p
                                className={`font-semibold mt-2 ${
                                    booking.status === "Upcoming"
                                        ? "text-blue-600"
                                        : "text-gray-500"
                                }`}
                            >
                                Status: {booking.status}
                            </p>
                        </div>
                    ))}
                </div>
            </div>

            {/* Leave Review Button */}
            <div className="mb-10">
                <button
                    onClick={() => setShowReviewModal(true)}
                    className="px-6 py-3 bg-green-500 text-white rounded-lg hover:bg-green-600"
                >
                    Leave a Review
                </button>
            </div>

            {/* Reviews Section */}
            <div>
                <h3 className="text-2xl font-bold mb-6">My Reviews</h3>
                {reviews.length === 0 ? (
                    <p className="text-gray-500">No reviews yet.</p>
                ) : (
                    <div className="space-y-4">
                        {reviews.map((review, index) => (
                            <div key={index} className="p-4 bg-white rounded-xl shadow">
                                <p className="font-semibold">{review.tutor}</p>
                                <p>⭐ {review.rating} / 5</p>
                                <p>{review.comment}</p>
                                <p className="text-sm text-gray-500 mt-2">
                                    {review.date}
                                </p>
                            </div>
                        ))}
                    </div>
                )}
            </div>

            {/* Review Modal */}
            {showReviewModal && (
                <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
                    <div className="bg-white p-6 rounded-xl shadow-lg w-96">
                        <h3 className="text-xl font-bold mb-4">Leave a Review</h3>

                        {/* Tutor Dropdown */}
                        <label className="block mb-2 font-medium">Tutor</label>
                        <select
                            name="tutor"
                            value={reviewForm.tutor}
                            onChange={handleChange}
                            className="w-full border rounded-lg p-2 mb-4"
                        >
                            <option value="">Select a tutor</option>
                            {bookings.map((b, i) => (
                                <option key={i} value={b.tutor}>
                                    {b.tutor}
                                </option>
                            ))}
                        </select>

                        {/* Rating */}
                        <label className="block mb-2 font-medium">Rating</label>
                        <input
                            type="number"
                            name="rating"
                            min="1"
                            max="5"
                            value={reviewForm.rating}
                            onChange={handleChange}
                            className="w-full border rounded-lg p-2 mb-4"
                        />

                        {/* Comment */}
                        <label className="block mb-2 font-medium">Comment</label>
                        <textarea
                            name="comment"
                            value={reviewForm.comment}
                            onChange={handleChange}
                            className="w-full border rounded-lg p-2 mb-4"
                        />

                        {/* Buttons */}
                        <div className="flex justify-end space-x-2">
                            <button
                                onClick={() => setShowReviewModal(false)}
                                className="px-4 py-2 bg-gray-300 rounded-lg hover:bg-gray-400"
                            >
                                Cancel
                            </button>
                            <button
                                onClick={submitReview}
                                className="px-4 py-2 bg-green-500 text-white rounded-lg hover:bg-green-600"
                            >
                                Submit
                            </button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}