package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        //@NotNull //usando o Bean Validation para não deixar o campo nome nulo
        @NotBlank //Bean Validation para verificar se o campo não está em branco e nulo
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //usando expressão regular para limitar a inserção dos dígitos (\\d) entre 4 a 6 no max {4,6}
        String crm,
        @NotNull //aqui não é @NotBlank porque esse é só para String
        Especialidade especialidade,
        //o @Valid vai dizer que é pra validar o Validation também do DTO DadosEndereco
        @NotNull @Valid DadosEndereco endereco) {
}
