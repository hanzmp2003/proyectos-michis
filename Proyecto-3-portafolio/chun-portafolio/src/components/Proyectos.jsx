export default function Proyectos() {
  const proyectos = [
    {
      title: "Proyecto Pokémon",
      img: "/pokemon.png",
      desc: "Gestión de personajes Pokémon mediante estructuras y lógica.",
    },
    {
      title: "Tetris",
      img: "/tetris.png",
      desc: "Versión del clásico Tetris para practicar estructuras de datos.",
    },
    {
      title: "Lista Enlazada de Youtubers",
      img: "/youtubers.png",
      desc: "Administración de canales usando una lista enlazada.",
    },
  ];

  return (
    <section className="px-6 md:px-24 py-14 fade-up">
      <h2 className="text-4xl text-pink font-semibold mb-6">Proyectos</h2>

      <div className="grid md:grid-cols-2 gap-10">
        {proyectos.map((p) => (
          <div
            key={p.title}
            className="p-6 bg-[#12264d] rounded-2xl shadow-xl hover:scale-[1.03] transition"
          >
            <img src={p.img} className="w-full rounded-xl mb-4" />
            <h3 className="text-3xl text-pink font-semibold">{p.title}</h3>
            <p className="text-light/80 mt-2 mb-4">{p.desc}</p>
            <a className="text-rose underline">Ver proyecto</a>
          </div>
        ))}
      </div>
    </section>
  );
}
