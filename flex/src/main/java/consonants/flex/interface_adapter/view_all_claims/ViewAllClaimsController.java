package consonants.flex.interface_adapter.view_all_claims;


import consonants.flex.entity.Claim;

import consonants.flex.use_case.view_all_claims.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/claims")
public class ViewAllClaimsController {
    @Autowired
    private ViewAllClaimsInputBoundary viewAllClaimsInteractor;

    @GetMapping
    public ResponseEntity<List<Claim>> getAllClaims() {
        return viewAllClaimsInteractor.execute();
        }

    }

