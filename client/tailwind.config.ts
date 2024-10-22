import type { Config } from "tailwindcss";
import { createThemes } from "tw-colors";
import colors from "tailwindcss/colors";

type ColorShades = {
  [key: string]: string; // Each shade is a string (the hex value)
};

type TailwindColors = {
  [color: string]: ColorShades;
};

const baseColors: Array<keyof typeof colors> = [
  "gray",
  "red",
  "yellow",
  "green",
  "blue",
  "indigo",
  "purple",
  "pink",
];

// mapping of tailwindcss colors to their shades
const shadeMapping: Record<string, string> = {
  // if it's "50" in light theme, it should be "900" in dark theme
  "50": "900",
  "100": "800",
  "200": "700",
  "300": "600",
  "400": "500",
  "500": "400",
  "600": "300",
  "700": "200",
  "800": "100",
  "900": "50",
};

const generateThemeObject = (
  colors: TailwindColors,
  mapping: Record<string, string>,
  invert = false
): Record<string, Record<string, string>> => {
  const theme: Record<string, Record<string, string>> = {};
  baseColors.forEach((color) => {
    theme[color] = {};
    Object.entries(mapping).forEach(([key, value]) => {
      const shadeKey = invert ? value : key;
      theme[color][key] = colors[color][shadeKey];
    });
  });
  return theme;
};

const lightTheme = generateThemeObject(
  colors as unknown as TailwindColors,
  shadeMapping
);
const darkTheme = generateThemeObject(
  colors as unknown as TailwindColors,
  shadeMapping,
  true
);

const themes = {
  light: {
    ...lightTheme,
    white: "#ffffff",
  },
  dark: {
    ...darkTheme,
    white: colors.gray["950"],
    black: colors.gray["50"],
  },
};

const config: Config = {
  // we have to set the darkMode to "class" to use the dark mode feature
  darkMode: "class",
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      backgroundImage: {
        "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
        "gradient-conic":
          "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
      },
    },
  },
  plugins: [createThemes(themes)],
};

export default config;
