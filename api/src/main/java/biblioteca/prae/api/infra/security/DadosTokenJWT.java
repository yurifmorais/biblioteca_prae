package biblioteca.prae.api.infra.security;

//para devolver o token como um JSON
//public record DadosTokenJWT(String token) {
//}



//teste abaixo
//para devolver o token como um JSON
public record DadosTokenJWT(String token, String email, String nome, Long id, Boolean is_admin) {
}
