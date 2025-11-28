export default function Habilidades() {
  const skills = [
    "Java", "Python", "HTML", "CSS", "JavaScript", "Git", "GitHub", "Estructuras de Datos",
  ];

  return (
    <section className="px-6 md:px-24 py-14 fade-up">
      <h2 className="text-4xl text-sakuraDark font-semibold mb-6 drop-shadow">
        Habilidades
      </h2>

      <div className="flex flex-wrap gap-3">
        {skills.map((s) => (
          <span
            key={s}
            className="px-4 py-2 rounded-full bg-lilac text-[#4a4453] font-semibold shadow-kawaii hover:scale-105 transition"
          >
            {s}
          </span>
        ))}
      </div>
    </section>
  );
}