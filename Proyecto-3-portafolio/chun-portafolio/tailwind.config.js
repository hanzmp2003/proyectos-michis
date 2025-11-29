
/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        sakura: "#b8c5e0",     // celeste suave (antes rosado)
        sakuraDark: "#8fa3c7", // celeste más intenso
        cream: "#f5f7fa",      // blanco azulado muy suave
        lilac: "#d4dff5",      // celeste lavanda
        bubble: "#e8eef9",     // celeste bubble suave
        skyPastel: "#a8d5e2", // celeste pastel adicional
      },
      boxShadow: {
        kawaii: "0 4px 15px rgba(168, 213, 226, 0.55)",    // sombra celeste
        softpink: "0 2px 10px rgba(143, 163, 199, 0.45)",  // sombra celeste suave
      },
    },
  },
  plugins: [],
};