export default function Header() {
  return (
    <header className="text-center py-20 relative overflow-hidden fade-in shadow-kawaii">
     
      {/* Imagen de fondo */}
      <img
        src="https://aicdn.picsart.com/b93e3e6b-6dc4-4413-9f6f-cef8f82503b4.jpg"
        className="absolute inset-0 w-full h-full object-cover object-top"
      />

      {/* Contenido */}
      <div className="relative z-10">
        <img
          src="/perfil.jpeg"
          className="w-40 h-40 rounded-full mx-auto border-4 border-white shadow-softpink"
        />

        <h1 className="text-5xl font-bold mt-4 tracking-wide drop-shadow" style={{ color: "#405a7cff" }}>
          Akaringo
        </h1>

        <p className="text-lg mt-2 font-semibold" style={{ color: "#415775ff" }}>
          Estudiante de Ingeniería en Computación - UCR
        </p>
      </div>
    </header>
  );
}