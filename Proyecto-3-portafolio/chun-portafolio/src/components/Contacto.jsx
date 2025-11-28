export default function Contacto() {
  return (
    <footer className="px-6 md:px-24 py-20 bg-bubble relative overflow-hidden fade-up shadow-kawaii">
      <img
        src="/flowers_bottom.png"
        className="absolute bottom-0 right-0 w-72 opacity-40"
      />

      <div className="grid md:grid-cols-2 gap-10 relative z-10">
        <div>
          <h2 className="text-4xl text-sakuraDark font-semibold mb-3 drop-shadow">
            Contacto
          </h2>
          <p className="text-sakura text-lg">Email: akaringo@example.com</p>
          <p className="text-sakura text-lg mt-1">GitHub: github.com/akaringo</p>
        </div>

        <div>
          <h2 className="text-4xl text-sakuraDark font-semibold mb-3 drop-shadow">
            Repositorio del Portafolio
          </h2>
          <a className="text-sakura underline hover:text-sakuraDark transition">
            Ver en GitHub
          </a>
        </div>
      </div>
    </footer>
  );
}
