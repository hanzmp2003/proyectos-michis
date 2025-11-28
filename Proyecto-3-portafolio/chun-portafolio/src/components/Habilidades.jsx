export default function Habilidades() {
  const skills = [
    "Java",
    "Python",
    "HTML",
    "CSS",
    "JavaScript",
    "Git",
    "GitHub",
    "Estructuras de Datos",
  ];

  return (
    <section className="px-6 md:px-24 py-14 fade-up">
      <h2 className="text-4xl text-pink font-semibold mb-6">Habilidades</h2>
      <div className="flex flex-wrap gap-3">
        {skills.map((s) => (
          <span
            key={s}
            className="px-4 py-2 rounded-full bg-rose text-dark font-semibold shadow hover:scale-105 transition"
          >
            {s}
          </span>
        ))}
      </div>
    </section>
  );
}
