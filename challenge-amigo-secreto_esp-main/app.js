// El principal objetivo de este desafío es fortalecer tus habilidades en lógica de programación. Aquí deberás desarrollar la lógica para resolver el problema.

// Solución 1

/*const $ = (id) => document.querySelector(id);
const input = $("#amigo");
const friendsList = $("#listaAmigos");
const winnersList = $("#resultado");
const amigos = [];

function agregarAmigo() {
  if (winnersList.querySelectorAll("li").length > 0) {
    winnersList.innerHTML = "";
  }

  const nuevoAmigo = input.value.trim();

  if (!nuevoAmigo || amigos.includes(nuevoAmigo)) {
    return alert("Por favor, ingrese un nombre válido y único en la lista");
  }

  amigos.push(nuevoAmigo);
  actualizarAmigos();
  limpiarInput();
}

function actualizarAmigos() {
  let template = "";

  for (let i = 0; i < amigos.length; i++) {
    template += `<li class="winner">${amigos[i]}</li>`;
  }

  friendsList.innerHTML = "";
  friendsList.innerHTML = template;
}

function sortearAmigo() {
  if (amigos.length <= 1) {
    return alert("Debe haber al menos 2 nombres para poder iniciar");
  }

  const index = Math.floor(Math.random() * amigos.length);
  winnersList.innerHTML = `<li class="friend">${amigos[index]}</li>`;
  friendsList.innerHTML = "";
  amigos.length = 0;
  limpiarInput();
}

function limpiarInput() {
  input.value = "";
  input.focus();
}*/

// Solución 2

const $ = (id) => document.querySelector(id);
const input = $("#amigo");
const friendsList = $("#listaAmigos");
const winnersList = $("#resultado");

function agregarAmigo() {
  const newFriend = input.value.trim();

  if (validarTexto(newFriend)) {
    input.focus();
    return alert(
      "El nombre no puede estar vacío ni contener solo espacios en blanco o estos caracteres < >"
    );
  }

  if (winnersList.children.length > 0) {
    winnersList.replaceChildren();
  }

  render(friendsList, `<li class="friend">${newFriend}</li>`);
  input.value = "";
  input.focus();
}

function sortearAmigo() {
  const friends = friendsList.querySelectorAll(".friend");

  if (friends.length <= 1) {
    return alert("Debe haber al menos 2 amigos para sortear");
  }

  const index = Math.floor(Math.random() * friends.length);
  const winner = friends[index].textContent;

  friendsList.replaceChildren();
  render(winnersList, `<li class="winner">${winner}</li>`);
  input.focus();
}

function render(target, template) {
  target.insertAdjacentHTML("beforeend", template);
}

function validarTexto(template) {
  return !template || template.startsWith("<") || template.endsWith(">");
}
