export default function Timeline() {
  const eventos = [
    { fecha: "2023 - Actualidad", texto: "Estudios en Ingeniería en la UCR" },
    { fecha: "2022", texto: "Primeros proyectos personales" },
    { fecha: "2021", texto: "Interés por videojuegos y computadoras" },
  ];

  return (
    <section className="px-6 md:px-24 py-14 fade-up">
      <h2 className="text-4xl text-sakuraDark font-semibold mb-6 drop-shadow">
        Mi Historia
      </h2>

      <div className="border-l-4 border-sakura pl-6 space-y-6">
        {eventos.map((e) => (
          <div key={e.fecha} className="fade-left">
            <h3 className="text-2xl text-sakuraDark font-semibold">{e.fecha}</h3>
            <p className="text-[#6d5f79]">{e.texto}</p>
          </div>
        ))}
      </div>
    </section>
  );
}
