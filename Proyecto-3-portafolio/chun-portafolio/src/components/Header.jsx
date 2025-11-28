export default function Header() {
  return (
    <header className="text-center py-16 relative overflow-hidden fade-in">
      <img
        src="/flowers_top.png"
        className="absolute top-0 left-0 w-64 opacity-40"
      />

      <img
        src="/profile.png"
        className="w-40 h-40 rounded-full mx-auto border-4 border-rose shadow-xl"
      />

      <h1 className="text-5xl font-bold mt-4 text-pink tracking-wide">
        Akaringo
      </h1>

      <p className="text-rose text-lg mt-2">
        Estudiante de Ingeniería en Computación - UCR
      </p>
    </header>
  );
}
