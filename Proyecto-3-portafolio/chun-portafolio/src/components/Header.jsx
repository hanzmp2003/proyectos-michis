export default function Header() {
  return (
    <header className="text-center py-20 relative overflow-hidden fade-in shadow-kawaii">
      {/* Imagen de fondo */}
      <img
        src="https://i.pinimg.com/originals/29/bc/b4/29bcb4eb35e83e53b2c9ec83edf88775.gif"
        className="absolute inset-0 w-full h-full object-cover"
      />
      
      {/* Overlay para mejor contraste */}
      <div className="absolute inset-0 bg-gradient-to-b from-white/30 to-white/60"></div>

      {/* Contenido */}
      <div className="relative z-10">
        <img
          src="/perfil.jpeg"
          className="w-40 h-40 rounded-full mx-auto border-4 border-sakura shadow-softpink"
        />

        <h1 className="text-5xl font-bold mt-4 text-sakuraDark tracking-wide drop-shadow">
          Akaringo
        </h1>

        <p className="text-sakura text-lg mt-2 font-medium">
          Estudiante de Ingeniería en Computación - UCR
        </p>
      </div>
    </header>
  );
}
