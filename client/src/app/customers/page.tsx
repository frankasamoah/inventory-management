"use client";

import React from "react";
import { useGetCustomersQuery } from "@/state/api";
import Header from "@/app/(components)/Header";
import { DataGrid, GridColDef } from "@mui/x-data-grid";

// this is the data that will be displayed in the table using your api so
// you need to make sure that the fields match the data you are fetching
const columns: GridColDef[] = [
  { field: "customerId", headerName: "ID", width: 90 },
  { field: "name", headerName: "Name", width: 200 },
  { field: "email", headerName: "Email", width: 200 },
];

const Customers = () => {
  const { data, isError, isLoading } = useGetCustomersQuery();
  const customers = data?.customers || [];

  console.log(customers);
  if (isLoading) {
    return <div className="py-4">Loading...</div>;
  }

  if (isError || !customers) {
    return (
      <div className="text-center text-red-500 py-4">Failed to fetch users</div>
    );
  }
  return (
    <div className="flex flex-col">
      <Header name="Customers" />
      <DataGrid
        rows={customers}
        columns={columns}
        getRowId={(row) => row.customerId}
        checkboxSelection
        className="bg-white shadow rounded-lg border border-gray-200 mt-5 !text-gray-700"
      />
    </div>
  );
};

export default Customers;
