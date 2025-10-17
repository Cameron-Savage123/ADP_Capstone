// src/components/PaymentTable.jsx
import React, { useState } from "react";

export default function PaymentTable({ payments }) {
    const [selectedPayment, setSelectedPayment] = useState(null);

    const handleView = (payment) => {
        setSelectedPayment(payment);
    };

    return (
        <div className="p-4">
            <h2 className="text-xl font-bold mb-4">Payments</h2>
            <table className="min-w-full border border-gray-300">
                <thead>
                <tr className="bg-gray-100">
                    <th className="p-2 border">Payment ID</th>
                    <th className="p-2 border">Amount</th>
                    <th className="p-2 border">Method</th>
                    <th className="p-2 border">Status</th>
                    <th className="p-2 border">Action</th>
                </tr>
                </thead>
                <tbody>
                {payments.length === 0 ? (
                    <tr>
                        <td colSpan={5} className="p-2 text-center">No payments available</td>
                    </tr>
                ) : (
                    payments.map((p) => (
                        <tr key={p.paymentID}>
                            <td className="p-2 border">{p.paymentID}</td>
                            <td className="p-2 border">{p.amount}</td>
                            <td className="p-2 border">{p.paymentMethod}</td>
                            <td className="p-2 border">{p.status}</td>
                            <td className="p-2 border">
                                <button
                                    className="px-2 py-1 bg-blue-500 text-white rounded hover:bg-blue-600"
                                    onClick={() => handleView(p)}
                                >
                                    View
                                </button>
                            </td>
                        </tr>
                    ))
                )}
                </tbody>
            </table>

            {selectedPayment && (
                <div className="mt-4 p-4 border rounded bg-gray-50">
                    <h3 className="text-lg font-semibold mb-2">Payment Details</h3>
                    <p><strong>ID:</strong> {selectedPayment.paymentID}</p>
                    <p><strong>Amount:</strong> {selectedPayment.amount}</p>
                    <p><strong>Date:</strong> {selectedPayment.paymentDate}</p>
                    <p><strong>Method:</strong> {selectedPayment.paymentMethod}</p>
                    <p><strong>Status:</strong> {selectedPayment.status}</p>
                    <p><strong>Transaction ID:</strong> {selectedPayment.transactionID}</p>
                </div>
            )}
        </div>
    );
}