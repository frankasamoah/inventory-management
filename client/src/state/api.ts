import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

// interfaces for the data we are fetching
export interface Product {
  productId: string;
  name: string;
  price: number;
  rating?: number;
  stockQuantity: number;
}

export interface NewProduct {
  name: string;
  price: number;
  rating?: number;
  stockQuantity: number;
}

export interface SalesSummary {
  salesSummaryId: string;
  totalValue: number;
  changePercentage?: number;
  date: string;
}

export interface PurchaseSummary {
  purchaseSummaryId: string;
  totalPurchased: number;
  changePercentage?: number;
  date: string;
}

export interface ExpenseSummary {
  expenseSummarId: string;
  totalExpenses: number;
  date: string;
}

export interface ExpenseByCategory {
  expenseByCategorySummaryId: string;
  category: string;
  amount: string;
  date: string;
}

export interface DashboardMetrics {
  popularProducts: Product[];
  salesSummary: SalesSummary[];
  purchaseSummary: PurchaseSummary[];
  expenseSummary: ExpenseSummary[];
  expenseByCategory: ExpenseByCategory[];
}

export interface CustomerData {
  [key: string]: Customer[];
}

export interface Customer {
  customerId: string;
  name: string;
  email: string;
}

export const api = createApi({
  // fetchBaseQuery is just like fetch, but it has some extra features
  baseQuery: fetchBaseQuery({ baseUrl: process.env.NEXT_PUBLIC_API_BASE_URL }),
  // reducerPath is the name of the slice in the Redux store || it is used to access the data in the store
  reducerPath: "api",
  // tags are used to invalidate the cache || if the data changes, the cache is invalidated
  tagTypes: ["DashboardMetrics", "Products", "Customers", "Expenses"],
  endpoints: (build) => ({
    // get request uses the query method || "void" means no parameters, so basically a get request
    getDashboardMetrics: build.query<DashboardMetrics, void>({
      query: () => "/dashboard",
      providesTags: ["DashboardMetrics"],
    }),
    getProducts: build.query<Product[], string | void>({
      // search is optional, so it can be a string or void || search term
      query: (search) => ({
        url: "/products",
        params: search ? { search } : {},
      }),
      providesTags: ["Products"],
    }),
    // mutation is used for post, put etc requests || it uses the mutation method
    createProduct: build.mutation<Product, NewProduct>({
      query: (newProduct) => ({
        url: "/products",
        method: "POST",
        body: newProduct,
      }),
      // invalidatesTags is used to invalidate the cache || if the data changes, another request is made automatically
      invalidatesTags: ["Products"],
    }),
    // getCustomers: build.query<Customer[], void>({
    getCustomers: build.query<CustomerData, void>({
      query: () => "/customers",
      providesTags: ["Customers"],
    }),
    getExpensesByCategory: build.query<ExpenseByCategory[], void>({
      query: () => "/expenses",
      providesTags: ["Expenses"],
    }),
  }),
});

// export the hooks to use the data which are stored in the Redux store
export const {
  useGetDashboardMetricsQuery,
  useGetProductsQuery,
  useCreateProductMutation,
  useGetCustomersQuery,
  useGetExpensesByCategoryQuery,
} = api;
