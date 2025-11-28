export default function Timeline() {
  const eventos = [
    {
      fecha: "2023 - Actualidad",
      texto: "Estudios en Ingeniería en Computación en la UCR",
    },
    {
      fecha: "2022",
      texto: "Primeros proyectos personales en programación",
    },
    {
      fecha: "2021",
      texto: "Interés por videojuegos, tecnología y computadoras",
    },
  ];

  return (
    <section className="px-6 md:px-24 py-14 fade-up">
      <h2 className="text-4xl text-pink font-semibold mb-6">Mi Historia</h2>

      <div className="border-l-4 border-rose pl-6 space-y-6">
        {eventos.map((e) => (
          <div key={e.fecha} className="fade-left">
            <h3 className="text-2xl text-pink font-semibold">{e.fecha}</h3>
            <p className="text-light/80">{e.texto}</p>
          </div>
        ))}
      </div>
    </section>
  );
}
