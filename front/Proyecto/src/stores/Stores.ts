import { writable } from 'svelte/store';

// Crea una store exportada para `show` con un valor inicial
export const show = writable(false);
