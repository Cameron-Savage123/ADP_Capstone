// src/components/ReviewTable.jsx
import React, { useState } from "react";

export default function ReviewTable({ reviews }) {
    const [selectedReview, setSelectedReview] = useState(null);

    const handleView = (review) => {
        setSelectedReview(review);
    };

    return (
        <div className="p-4">
            <h2 className="text-xl font-bold mb-4">Reviews</h2>
            <table className="min-w-full border border-gray-300">
                <thead>
                <tr className="bg-gray-100">
                    <th className="p-2 border">Review ID</th>
                    <th className="p-2 border">Rating</th>
                    <th className="p-2 border">Comment</th>
                    <th className="p-2 border">Date Submitted</th>
                    <th className="p-2 border">Action</th>
                </tr>
                </thead>
                <tbody>
                {reviews.length === 0 ? (
                    <tr>
                        <td colSpan={5} className="p-2 text-center">No reviews available</td>
                    </tr>
                ) : (
                    reviews.map((r) => (
                        <tr key={r.reviewID}>
                            <td className="p-2 border">{r.reviewID}</td>
                            <td className="p-2 border">{r.rating}</td>
                            <td className="p-2 border">{r.comment}</td>
                            <td className="p-2 border">{r.dateSubmitted}</td>
                            <td className="p-2 border">
                                <button
                                    className="px-2 py-1 bg-blue-500 text-white rounded hover:bg-blue-600"
                                    onClick={() => handleView(r)}
                                >
                                    View
                                </button>
                            </td>
                        </tr>
                    ))
                )}
                </tbody>
            </table>

            {selectedReview && (
                <div className="mt-4 p-4 border rounded bg-gray-50">
                    <h3 className="text-lg font-semibold mb-2">Review Details</h3>
                    <p><strong>ID:</strong> {selectedReview.reviewID}</p>
                    <p><strong>Rating:</strong> {selectedReview.rating}</p>
                    <p><strong>Comment:</strong> {selectedReview.comment}</p>
                    <p><strong>Date Submitted:</strong> {selectedReview.dateSubmitted}</p>
                </div>
            )}
        </div>
    );
}