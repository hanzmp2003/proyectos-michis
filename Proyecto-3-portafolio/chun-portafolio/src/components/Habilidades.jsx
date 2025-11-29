export default function Habilidades() {
  const lenguajes = [
    "Java", "JavaScript", "HTML", "CSS", "Python"
  ];

  const herramientas = [
    "Canva", "Git", "GitHub", "Visual Studio Code"
  ];

  return (
    <section className="px-6 md:px-24 py-14 fade-up">
      <h2 className="text-4xl text-sakuraDark font-semibold mb-6 drop-shadow">
        Habilidades
      </h2>

      <div className="grid md:grid-cols-2 gap-6">
        {/* Lenguajes de Programación */}
        <div className="p-6 bg-bubble rounded-2xl shadow-kawaii">
          <h3 className="text-2xl text-sakuraDark font-semibold mb-4">
            Lenguajes de Programación
          </h3>
          <div className="flex flex-wrap gap-3">
            {lenguajes.map((l) => (
              <span
                key={l}
                className="px-4 py-2 rounded-full bg-lilac text-[#4a4453] font-semibold shadow-kawaii hover:scale-105 transition"
              >
                {l}
              </span>
            ))}
          </div>
        </div>

        {/* Herramientas y Software */}
        <div className="p-6 bg-bubble rounded-2xl shadow-kawaii">
          <h3 className="text-2xl text-sakuraDark font-semibold mb-4">
            Herramientas y Software
          </h3>
          <div className="flex flex-wrap gap-3">
            {herramientas.map((h) => (
              <span
                key={h}
                className="px-4 py-2 rounded-full bg-lilac text-[#4a4453] font-semibold shadow-kawaii hover:scale-105 transition"
              >
                {h}
              </span>
            ))}
          </div>
        </div>
      </div>
    </section>
  );
}