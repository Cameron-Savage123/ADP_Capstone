import React, { useState } from "react";
import { createReview } from "../api/reviewApi"; // ✅ import your API

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

    const [selectedBooking, setSelectedBooking] = useState("");
    const [reviews, setReviews] = useState([]);
    const [showReviewModal, setShowReviewModal] = useState(false);
    const [reviewForm, setReviewForm] = useState({
        rating: 5,
        comment: "",
    });

    // Handle form change
    const handleChange = (e) => {
        const { name, value } = e.target;
        setReviewForm({ ...reviewForm, [name]: value });
    };

    // Generate unique ID (simple random string)
    const generateReviewID = () =>
        "REV-" + Math.random().toString(36).substring(2, 9).toUpperCase();

    // Handle review submission
    const submitReview = async () => {
        if (!reviewForm.comment.trim()) {
            alert("Please leave a comment.");
            return;
        }

        const newReview = {
            reviewID: generateReviewID(),
            rating: reviewForm.rating,
            comment: reviewForm.comment,
            dateSubmitted: new Date().toISOString(),
        };

        try {
            // ✅ Insert into database
            const savedReview = await createReview(newReview);

            // ✅ Add to local list for display
            setReviews([...reviews, savedReview]);
            alert("Review submitted successfully!");

            // ✅ Reset modal & form
            setShowReviewModal(false);
            setReviewForm({ rating: 5, comment: "" });
        } catch (err) {
            console.error("Error submitting review:", err);
            alert("Failed to submit review. Please try again.");
        }
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
                <h3 className="text-2xl font-bold mb-4">My Bookings</h3>
                <select
                    className="w-full p-3 border rounded-lg mb-6"
                    value={selectedBooking}
                    onChange={(e) => setSelectedBooking(e.target.value)}
                >
                    <option value="">Select a booking to view details</option>
                    {bookings.map((booking, index) => (
                        <option key={index} value={index}>
                            {booking.tutor} — {new Date(booking.startTime).toLocaleDateString()}
                        </option>
                    ))}
                </select>

                {selectedBooking !== "" && (
                    <div className="p-6 bg-white rounded-xl shadow transition">
                        <h4 className="text-xl font-semibold mb-2">
                            Tutor: {bookings[selectedBooking].tutor}
                        </h4>
                        <p><span className="font-semibold">Start:</span> {new Date(bookings[selectedBooking].startTime).toLocaleString()}</p>
                        <p><span className="font-semibold">End:</span> {new Date(bookings[selectedBooking].endTime).toLocaleString()}</p>
                        <p><span className="font-semibold">Location:</span> {bookings[selectedBooking].location}</p>
                        <p><span className="font-semibold">Mode:</span> {bookings[selectedBooking].mode}</p>
                        <p className={`font-semibold mt-2 ${bookings[selectedBooking].status === "Upcoming" ? "text-blue-600" : "text-gray-500"}`}>
                            Status: {bookings[selectedBooking].status}
                        </p>
                    </div>
                )}
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
                                <p>⭐ {review.rating} / 5</p>
                                <p>{review.comment}</p>
                                <p className="text-sm text-gray-500 mt-2">
                                    {new Date(review.dateSubmitted).toLocaleString()}
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

                        {/* Rating */}
                        <div className="mb-4">
                            <label className="block mb-2 font-medium" htmlFor="rating">
                                Rating
                            </label>
                            <input
                                id="rating"
                                type="number"
                                name="rating"
                                min="1"
                                max="5"
                                value={reviewForm.rating}
                                onChange={handleChange}
                                className="w-full border rounded-lg p-2"
                            />
                        </div>

                        {/* Comment */}
                        <div className="mb-4">
                            <label className="block mb-2 font-medium" htmlFor="comment">
                                Comment
                            </label>
                            <textarea
                                id="comment"
                                name="comment"
                                value={reviewForm.comment}
                                onChange={handleChange}
                                placeholder="Include the tutor's name in your comment"
                                className="w-full border rounded-lg p-2"
                            />
                        </div>

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