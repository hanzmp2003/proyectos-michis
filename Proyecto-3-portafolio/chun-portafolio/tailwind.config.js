/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        dark: "#0a0f1c",
        light: "#ffffff",
        rose: "#f5a8b8",
        pink: "#ff6b9c",
      },
    },
  },
  plugins: [],
};
