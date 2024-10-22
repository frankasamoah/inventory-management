import { LucideIcon } from "lucide-react";

export type StatDetail = {
  title: string;
  amount: string;
  changePercentage: number;
  IconComponent: LucideIcon;
};

export type StatCardProps = {
  title: string;
  primaryIcon: LucideIcon;
  details: StatDetail[];
  dateRange: string;
};
