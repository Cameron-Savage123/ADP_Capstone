/*
Keewan Titus
230778577
 */
import React, {useState} from 'react'




export default function SubjectTable({ subjects }) {
    const [selectedSubject, setSelectedSubject] = useState(null);

    const handleView = (subject) => {
        setSelectedSubject(subject);
    };

    return (
        <div className="p-4">
            <h2 className="text-xl font-bold mb-4">Payments</h2>
            <table className="min-w-full border border-gray-300">
                <thead>
                <tr className="bg-gray-100">
                    <th className="p-2 border">SubjectCode</th>
                    <th className="p-2 border">SubjectName</th>
                    <th className="p-2 border">SubjectDescription</th>
                    <th className="p-2 border">Department</th>
                    <th className="p-2 border">DifficultyLevel</th>
                    <th className="p-2 border">Actions</th>
                </tr>
                </thead>
                <tbody>
                {subjects.length === 0 ? (
                    <tr>
                        <td colSpan={5} className="p-2 text-center">No subjects available</td>
                    </tr>
                ) : (
                    subjects.map((s) => (
                        <tr key={s.subjectCode}>
                            <td className="p-2 border">{s.subjectCode}</td>
                            <td className="p-2 border">{s.subjectName}</td>
                            <td className="p-2 border">{s.subjectDescription}</td>
                            <td className="p-2 border">{s.department}</td>
                            <td className="p-2 border">{s.difficultyLevel}</td>
                            <td className="p-2 border">
                                <button
                                    className="px-2 py-1 bg-blue-500 text-white rounded hover:bg-blue-600"
                                    onClick={() => setSelectedSubject(s)}
                                >
                                    View
                                </button>
                            </td>
                        </tr>
                    ))
                )}
                </tbody>
            </table>

            {selectedSubject && (
                <div className="mt-4 p-4 border rounded bg-gray-50">
                    <h3 className="text-lg font-semibold mb-2">Subject Details</h3>
                    <p><strong>Code:</strong> {selectedSubject.subjectCode}</p>
                    <p><strong>Name:</strong> {selectedSubject.subjectName}</p>
                    <p><strong>Description:</strong> {selectedSubject.subjectDescription}</p>
                    <p><strong>Department:</strong> {selectedSubject.department}</p>
                    <p><strong>Level:</strong> {selectedSubject.difficultyLevel}</p>

                </div>
            )}
        </div>
    );
}