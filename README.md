# Framework para Desenvolvimento de Software

Projetos das aulas práticas da disciplina **Framework para Desenvolvimento de Software**  
Faculdade Anhanguera de São Gonçalo — ADS (EAD)

Aluno: Marcelo Silvestre Leite  
Matrícula: 2025173333

## Pastas

| Pasta | Aula | O que faz |
|---|---|---|
| `calculadora_salario_flask/` | U4 A4 — Framework Python | Calculadora web de salário líquido em Flask |
| `cadastro_produtos_android/` | U3 A4 — Frameworks mobile | App Android (Java) com cadastro de produtos e SQLite |

## Como rodar o Flask

```bash
cd calculadora_salario_flask
python -m venv venv
# Windows:
venv\Scripts\activate
# Linux/Mac:
# source venv/bin/activate
pip install -r requirements.txt
python app.py
```

Abra http://127.0.0.1:5000

Regras da aula:

- INSS = 8% do salário bruto
- IR = 15% do bruto se o valor for **maior** que R$ 2.500,00
- Cada dependente soma R$ 200,00 no líquido
- Recusa salário negativo, dependente negativo e entrada não numérica

## Como rodar o Android

1. Abra o Android Studio
2. **File > Open** e selecione a pasta `cadastro_produtos_android`
3. Espere o Gradle sincronizar
4. Rode no emulador (API 24+)

Validações:

- Nome com no mínimo 3 caracteres
- Preço numérico e maior que zero
- Dados ficam no SQLite (`produtos.db`) depois de fechar o app
