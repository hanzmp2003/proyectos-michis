export default function SobreMi() {
  return (
    <section className="px-6 md:px-24 py-14 fade-up">
      <div className="p-6 bg-bubble rounded-2xl shadow-kawaii relative overflow-hidden">
        <h2 className="text-4xl text-sakuraDark font-semibold mb-4 drop-shadow">
          Sobre mí
        </h2>
        <p className="text-lg leading-8 text-[#4a4453] pr-40 mb-6">
          Me llamo Chun, desarrolladora en formación con pasión por el diseño creativo y las interfaces bonitas. 
          Me gusta crear experiencias suaves y amigables.
        </p>
        
        {/* Imagen en la esquina inferior derecha */}
        <img
          src="/ardilla.png"
          alt="Ardilla"
          className="absolute bottom-4 right-4 w-36 opacity-90" //w - # es el tamaño de la imagen
        />
      </div>
    </section>
  );
}