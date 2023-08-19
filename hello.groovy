@RestController
class HelloController {
	@GetMapping("/")
	def hello() {
		return "Hello SpringBoot CH"
	}
}
