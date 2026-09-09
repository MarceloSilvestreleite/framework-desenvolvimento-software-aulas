from flask import Flask, render_template, request

app = Flask(__name__)

ALIQUOTA_INSS = 0.08
ALIQUOTA_IR = 0.15
LIMITE_IR = 2500.00
ABATIMENTO_DEPENDENTE = 200.00


def calcular_salario_liquido(salario_bruto, dependentes):
    """Regras simplificadas do roteiro da aula."""
    if salario_bruto < 0:
        raise ValueError("Salário não pode ser negativo.")
    if dependentes < 0:
        raise ValueError("Número de dependentes não pode ser negativo.")

    inss = salario_bruto * ALIQUOTA_INSS
    ir = salario_bruto * ALIQUOTA_IR if salario_bruto > LIMITE_IR else 0.0
    abatimento = dependentes * ABATIMENTO_DEPENDENTE
    liquido = salario_bruto - inss - ir + abatimento

    return {
        "salario_bruto": salario_bruto,
        "dependentes": dependentes,
        "inss": inss,
        "ir": ir,
        "abatimento": abatimento,
        "liquido": liquido,
    }


@app.route("/")
def index():
    return render_template("form.html")


@app.route("/resultado", methods=["POST"])
def resultado():
    try:
        salario = float(request.form["salario"].replace(",", "."))
        dependentes = int(request.form["dependentes"])
    except (ValueError, KeyError, TypeError):
        return render_template(
            "erro.html",
            mensagem="Erro: insira valores numéricos válidos.",
        )

    try:
        dados = calcular_salario_liquido(salario, dependentes)
    except ValueError as exc:
        return render_template("erro.html", mensagem=str(exc))

    return render_template("resultado.html", **dados)


if __name__ == "__main__":
    app.run(debug=True)
