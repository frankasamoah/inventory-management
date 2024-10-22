// data.ts
import { DollarSign, TrendingUp, ArrowDownRight } from "lucide-react";
import { StatCardProps } from "./types";

export const statCardData: StatCardProps[] = [
  {
    title: "Sales Overview",
    primaryIcon: DollarSign, // Use the component directly
    dateRange: "Last 30 days",
    details: [
      {
        title: "Total Sales",
        amount: "$12,345",
        changePercentage: 5.6,
        IconComponent: TrendingUp, // Component will set its own size when rendered
      },
    ],
  },
  {
    title: "Revenue",
    primaryIcon: TrendingUp, // Use the component directly
    dateRange: "This month",
    details: [
      {
        title: "Net Revenue",
        amount: "$9,876",
        changePercentage: 3.4,
        IconComponent: ArrowDownRight, // Example of a different icon
      },
    ],
  },
  {
    title: "Expenses",
    primaryIcon: ArrowDownRight,
    dateRange: "Last quarter",
    details: [
      {
        title: "Total Expenses",
        amount: "$5,432",
        changePercentage: -1.2,
        IconComponent: DollarSign,
      },
    ],
  },
];
