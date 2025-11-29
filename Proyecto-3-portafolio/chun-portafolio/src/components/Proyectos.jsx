export default function Proyectos() {
  const proyectos = [
    { //El object sirve para ajustar la imagen con la posición que quiera
      title: "Proyecto Pokémon", 
      img: "/pokemon.jpeg", 
      desc: "Una simulación de combate simple en la terminal del famoso juego de Pokémon",
      tecnologias: ["Java"],
      imgPosition: "object-center"   //object - center  significa el centro de la imagen
    },
    { 
      title: "Tetris", 
      img: "/Tetris.jpg", 
      desc: "Una versión clásica del Tetris para práctica.",
      tecnologias: ["Java"],
      imgPosition: "object-bottom"   //object - bottom que se ajuste empezando desde abajo de la imagen
    },
    { 
      title: "Lista Enlazada de Youtubers", 
      img: "/Youtuber.jpeg", 
      desc: "Administración de canales suscriptos, cuenta con las opciones para agregar, consultar y desuscribirse",
      tecnologias: ["Java"],
      imgPosition: "object-[center_20%]"    //Ajuste de imagen personalizado, para que se note la cara
    },
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
            <img 
              src={p.img} 
              className={`w-full h-64 object-cover rounded-xl mb-4 shadow-softpink ${p.imgPosition}`}
            />
            <h3 className="text-3xl text-sakuraDark font-semibold">{p.title}</h3>
            <p className="text-[#6d5f79] mt-2 mb-4">{p.desc}</p>
            
            <div className="mb-4">
              <h4 className="text-lg text-sakuraDark font-semibold mb-2">Tecnologías:</h4>
              <div className="flex flex-wrap gap-2">
                {p.tecnologias.map((tech) => (
                  <span
                    key={tech}
                    className="px-3 py-1 rounded-full bg-lilac text-[#4a4453] font-semibold text-sm shadow-kawaii"
                  >
                    {tech}
                  </span>
                ))}
              </div>
            </div>
            
            <a className="text-sakura underline hover:text-sakuraDark transition">
              Ver proyecto
            </a>
          </div>
        ))}
      </div>
    </section>
  );
}