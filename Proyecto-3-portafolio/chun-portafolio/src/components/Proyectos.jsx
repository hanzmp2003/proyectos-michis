export default function Proyectos() {
  const proyectos = [
    { title: "Proyecto Pokémon", img: "/pokemon.png", desc: "Gestión de personajes Pokémon." },
    { title: "Tetris", img: "/tetris.png", desc: "Versión clásica para práctica." },
    { title: "Lista Enlazada de Youtubers", img: "/youtubers.png", desc: "Administración de canales." },
  ];

  return (
    <section className="px-6 md:px-24 py-14 fade-up">
      <h2 className="text-4xl text-sakuraDark font-semibold mb-6 drop-shadow">
        Proyectos
      </h2>

      <div className="grid md:grid-cols-2 gap-10">
        {proyectos.map((p) => (
          <div
            key={p.title}
            className="p-6 bg-bubble rounded-2xl shadow-kawaii hover:scale-[1.03] transition"
          >
            <img src={p.img} className="w-full rounded-xl mb-4 shadow-softpink" />
            <h3 className="text-3xl text-sakuraDark font-semibold">{p.title}</h3>
            <p className="text-[#6d5f79] mt-2 mb-4">{p.desc}</p>
            <a className="text-sakura underline hover:text-sakuraDark transition">
              Ver proyecto
            </a>
          </div>
        ))}
      </div>
    </section>
  );
}