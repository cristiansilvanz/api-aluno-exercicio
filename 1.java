@GetMapping("/bem-vindo")
public String boasVindas(@RequestParam String nome) {
        return "Bem-vindo " + nome + "!";
        }